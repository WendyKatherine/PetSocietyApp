package com.example.petapp

import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ContentFragmentInstrumentedTest {

    @Test
    fun testActualizarTextoPerfilSeMuestraCorrecto() {
        ActivityScenario.launch(MainActivity::class.java).onActivity { activity ->
            val fragment = activity
                .supportFragmentManager
                .findFragmentById(R.id.contentFragmentContainer) as ContentFragment

            fragment.actualizarTexto("Sección: Perfil")

            val nombreText = fragment.requireView()
                .findViewById<TextView>(R.id.txtPerfilNombre)
                .text
                .toString()

            assertEquals("🐾 Tabata Nala", nombreText)
        }
    }
}
