package cz.minarik.base.di.base

import cz.minarik.base.data.rest.ws.DummyApiService
import cz.minarik.base.common.prefs.PrefManager
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseRepository : KoinComponent {

    protected val prefs by inject<PrefManager>()

    protected val dummyWebService by inject<DummyApiService>()

}