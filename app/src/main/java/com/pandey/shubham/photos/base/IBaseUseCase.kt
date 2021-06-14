package com.pandey.shubham.photos.base

import com.pandey.shubham.photos.network.IResult
import kotlinx.coroutines.flow.Flow

/** A Use Case that takes an argument and returns a result. */
interface IBaseUseCase<in I, out R : Any> {

    /** Executes this use case with given input. */
    suspend operator fun invoke(input: I): Flow<IResult<R>>
}