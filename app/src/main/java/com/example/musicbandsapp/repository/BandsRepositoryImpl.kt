package com.example.musicbandsapp.repository

import android.content.Context
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.musicbandsapp.api.BandsService
import com.example.musicbandsapp.db.BandsDao
import com.example.musicbandsapp.model.Band
import com.example.musicbandsapp.util.Resource
import org.koin.java.KoinJavaComponent.inject

class BandsRepositoryImpl(private val bandsService: BandsService, private val context: Context) :
    BandsRepository {

    private val bandsDao: BandsDao by inject(BandsDao::class.java)
    private val imageLoader: ImageLoader by inject(ImageLoader::class.java)

    override suspend fun getBands(isForceReload: Boolean): Resource<List<Band>> {
        val bands = bandsDao.getAll()

        if (bands.isEmpty() || isForceReload) {
            val remoteBands = bandsService.getBands()
            remoteBands.data?.let {
                bandsDao.insertAll(it)

                it.forEach { band ->
                    imageLoader.apply {
                        enqueue(
                            ImageRequest.Builder(context)
                                .data(band.logoImage)
                                .build()
                        )

                        enqueue(
                            ImageRequest.Builder(context)
                                .data(band.bandImage)
                                .build()
                        )
                    }
                }
            }

            return remoteBands
        }

        return Resource.Success(bands)
    }

    override suspend fun getBandDetails(id: Long): Resource<Band> =
        Resource.Success(bandsDao.findById(id))
}