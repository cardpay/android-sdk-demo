package com.unlimint.data

import com.unlimint.data.network.BaseRequestRepository
import com.unlimint.data.network.NetworkApi
import com.unlimint.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    webservice: NetworkApi
) : BaseRequestRepository<NetworkApi>(webservice), Repository {

    override suspend fun getMobileToken(): Result<String> {
        return makeRequest { auth() }.map { it.token }
    }
}
