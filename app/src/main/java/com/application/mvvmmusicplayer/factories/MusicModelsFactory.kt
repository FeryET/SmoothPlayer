package com.application.mvvmmusicplayer.factories

interface MusicModelsFactory{
    object MusicLibraryModelFactory{
        fun createInstance(vararg info: String, modelType: String) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }}

object MusicLibraryModelFactory: MusicModelsFactory{
    override fun createInstance(vararg info: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}