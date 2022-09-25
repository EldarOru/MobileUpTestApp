package com.example.mobileuptestapp.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.mobileuptestapp.core.Mapper

interface Communication {

    interface Observe<A : Any> {
        fun observe(owner: LifecycleOwner, observer: Observer<A>)
    }

    interface SetValue<A : Any> : Mapper.Unit<A>

    interface Mutable<A : Any> : Observe<A>, SetValue<A>

    class Base<A : Any> : Mutable<A> {
        private val liveData = MutableLiveData<A>()

        override fun map(source: A) {
            liveData.value = source
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<A>) =
            liveData.observe(owner, observer)
    }
}