package es.babel.ema.presentation.ui.normalway.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.babel.ema.domain.model.User

class UserViewModel : ViewModel() {

    val user: MutableLiveData<User> = MutableLiveData()

    fun onStart(user: User?=null){
        user?.let { this.user.value = it }
    }


}
