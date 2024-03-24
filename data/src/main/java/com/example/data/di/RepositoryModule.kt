package com.example.data.di

import com.example.data.repositories.login.LoginRepositoryImpl
import com.example.data.repositories.register.RegisterRepositoryImpl
import com.example.domain.repositories.login.LoginRepository
import com.example.domain.repositories.register.RegisterRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.Binds


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindRegisterRepositoryImpl(
        repositoryImpl: RegisterRepositoryImpl
    ): RegisterRepository

    @Binds
    fun bindLoginRepositoryImpl(
        repositoryImpl: LoginRepositoryImpl
    ): LoginRepository

}