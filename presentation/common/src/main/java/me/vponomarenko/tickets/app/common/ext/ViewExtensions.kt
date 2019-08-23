package me.vponomarenko.tickets.app.common.ext

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import io.reactivex.Observable

/**
 * Author: Valery Ponomarenko
 * Date: 11/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
fun EditText.addTextChangedObservable(): Observable<String> =
    Observable.create<String> {
        val listener = object : TextWatcher {
            override fun afterTextChanged(p0: Editable) {
                it.onNext(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        }
        addTextChangedListener(listener)
        it.setCancellable {
            removeTextChangedListener(listener)
        }
    }