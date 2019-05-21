package asterixorobelix.jsonplaceholderusers.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@kotlin.annotation.MustBeDocumented
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)