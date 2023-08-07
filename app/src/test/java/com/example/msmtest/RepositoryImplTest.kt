package com.example.msmtest

import android.content.Context
import com.example.msmtest.data.database.dao.PeopleDAO
import com.example.msmtest.data.remote.Api
import com.example.msmtest.data.remote.dto.PeopleItemDto
import com.example.msmtest.data.remote.dto.PeopleModel
import com.example.msmtest.domain.respository.InternetConnectivityChecker
import com.example.msmtest.domain.respository.RepositoryImpl
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class RepositoryImplTest {

    private lateinit var api: Api
    private lateinit var peopleDAO: PeopleDAO
    private lateinit var repository: RepositoryImpl

    private lateinit var internetConnectivityChecker: InternetConnectivityChecker

    @Before
    fun setUp() {
        // Manually initialize mocks
        api = mock()
        peopleDAO = mock()
        mockContext = mock()
        internetConnectivityChecker = mock()


        repository = RepositoryImpl(api, peopleDAO, mockContext, internetConnectivityChecker)
    }


    @Test
    fun `test fetch with internet and empty database`() = runBlocking {



        whenever(internetConnectivityChecker.isInternetAvailable(mockContext)).thenReturn(true)
        whenever(api.getAllPeople()).thenReturn(mockApiResponse)
        whenever(peopleDAO.getAllPeople()).thenReturn(emptyList())

        val result = repository.getPeople()


        assertEquals(mockApiResponse.people, result)
    }

    @Test
    fun `test fetch without internet and empty database`() = runBlocking {
        // Mock no internet and empty database
        whenever(internetConnectivityChecker.isInternetAvailable(mockContext)).thenReturn(false)
        whenever(peopleDAO.getAllPeople()).thenReturn(emptyList())

        val result = repository.getPeople()

        // Depending on your expected behavior, adjust this.
        // For this example, I'm expecting an empty list:
        assertEquals(emptyList<PeopleItemDto>(), result)
    }

    @Test
    fun `test fetch without internet with data in database`() = runBlocking {
        // Mock no internet and data in the database
        whenever(internetConnectivityChecker.isInternetAvailable(mockContext)).thenReturn(false)
        whenever(peopleDAO.getAllPeople()).thenReturn(mockDatabaseResponse)

        val result = repository.getPeople()

        // The result should be the mockDatabaseResponse since it fetches from the local database
        assertEquals(mockDatabaseResponse, result)
    }





    // Mock data and context
    private val mockApiResponse = PeopleModel(listOf(PeopleItemDto(/* ... */)))
    private val mockDatabaseResponse = listOf(PeopleItemDto(/* ... */))
    private var mockContext: Context = mock()
}
