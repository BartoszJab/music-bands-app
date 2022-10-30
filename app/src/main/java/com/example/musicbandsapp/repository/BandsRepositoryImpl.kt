package com.example.musicbandsapp.repository

import com.example.musicbandsapp.api.BandsService
import com.example.musicbandsapp.db.BandsDao
import com.example.musicbandsapp.model.Band
import com.example.musicbandsapp.util.Resource
import org.koin.java.KoinJavaComponent.inject

class BandsRepositoryImpl(private val bandsService: BandsService) : BandsRepository {

    private val bandsDao: BandsDao by inject(BandsDao::class.java)

    override suspend fun getBands(): Resource<List<Band>> {
        val bands = bandsDao.getAll()

        if (bands.isEmpty()) {
            val remoteBands = bandsService.getBands()
            remoteBands.data?.let { bandsDao.insertAll(it) }

            return remoteBands
        }

        return Resource.Success(bands)
    }

    override suspend fun getBandDetails(id: Long): Resource<Band> =
        Resource.Success(bandsDao.findById(id))
}