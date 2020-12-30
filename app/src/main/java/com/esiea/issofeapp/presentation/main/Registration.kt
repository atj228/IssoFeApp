package com.esiea.issofeapp.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.esiea.issofeapp.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_registration.*
import org.koin.android.ext.android.inject

class Registration : AppCompatActivity() {

    private val registrationViewModel: RegistrationViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        registrationViewModel.regLiveData.observe(this, Observer {
            when(it){
                is LoginCreate -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Succès")
                        .setMessage("Votre compte a bien été crée")
                        .setPositiveButton("OK") { dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

                LoginExist -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Erreur")
                        .setMessage("Ce Login est déjà utilisé")
                        .setPositiveButton("OK"){ dialog, which ->
                            dialog.dismiss()
                        }
                        .show()
                }
            }
        })

        log_button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        registration_button.setOnClickListener(){
            registrationViewModel.onClickedReg(username_edit.text.toString().trim(), emailReg_edit.text.toString().trim(), passwordRe_edit.text.toString())
        }

    }
}