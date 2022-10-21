package com.ideaco.projectdia.ui.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ideaco.projectdia.data.repository.AuthenticationRepository
import com.ideaco.projectdia.ui.model.VerifyOtpResponse
import com.ideaco.projectdia.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class VerifyOtpViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val verifyOtpResponseLiveData = MutableLiveData<ViewState<VerifyOtpResponse>>()
    private val validationLiveData = MutableLiveData<ViewState<Boolean>>()

    fun validateData(phone: String, otp: String){
        if(phone.isEmpty() || otp.isEmpty()){
            validationLiveData.value = ViewState.error("Phone or OTP must be filled", false)
        }else{
            validationLiveData.value = ViewState.success(true)
        }
    }

    fun verifyOtp(phone: String, otp: String){
        verifyOtpResponseLiveData.value = ViewState.loading(null)

        compositeDisposable.add(
            authenticationRepository.verifyOtp(phone, otp)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<VerifyOtpResponse>(){
                    override fun onSuccess(t: VerifyOtpResponse) {
                       if(t.code == 200){
                           //success
                           verifyOtpResponseLiveData.value = ViewState.success(t)
                       }else{
                           //failed
                           verifyOtpResponseLiveData.value = ViewState.error("Something Wrong", null)
                       }
                    }

                    override fun onError(e: Throwable) {
                        verifyOtpResponseLiveData.value = ViewState.error("Error api", null)
                    }

                })
        )
    }

    fun getVerifyOtpResponseLiveData(): MutableLiveData<ViewState<VerifyOtpResponse>>
        = verifyOtpResponseLiveData

    fun getValidationLiveData(): MutableLiveData<ViewState<Boolean>> = validationLiveData

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }
}