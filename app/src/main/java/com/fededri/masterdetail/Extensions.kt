package com.fededri.masterdetail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import kotlin.reflect.KClass

inline fun <reified T : Fragment> Fragment.instantiate(klass: KClass<T>): T {
    return childFragmentManager.instantiate(klass)
}

inline fun <reified T : Fragment> FragmentManager.instantiate(klass: KClass<T>): T {
    return fragmentFactory.instantiate(klass)
}

inline fun <reified T : Fragment> FragmentFactory.instantiate(klass: KClass<T>): T {
    return instantiate(klass.java.classLoader!!, klass.java.name) as T
}