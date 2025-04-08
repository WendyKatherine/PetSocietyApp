package com.example.petapp

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val btnPerfil = view.findViewById<Button>(R.id.btnPerfil)
        val btnFotos = view.findViewById<Button>(R.id.btnFotos)
        val btnVideo = view.findViewById<Button>(R.id.btnVideo)
        val btnWeb = view.findViewById<Button>(R.id.btnWeb)
        val btnBotones = view.findViewById<Button>(R.id.btnBotones)


        btnPerfil.apply {
            text = ""
            background = ContextCompat.getDrawable(requireContext(), R.drawable.round_button_bg)

            setPadding(0, 50, 0, 0)

            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.pet)
            icon?.setBounds(0, 0, 96, 96)
            setCompoundDrawables(null, icon, null, null)

            val params = LinearLayout.LayoutParams(200, 200)
            params.setMargins(0, 24, 0, 24)
            layoutParams = params

            setOnClickListener {
                actualizarContenido("Sección: Perfil")
            }
        }

        btnFotos.apply {
            text = ""
            background = ContextCompat.getDrawable(requireContext(), R.drawable.round_button_bg)

            setPadding(0, 50, 0, 0)

            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.photo)
            icon?.setBounds(0, 0, 96, 96)
            setCompoundDrawables(null, icon, null, null)

            val params = LinearLayout.LayoutParams(200, 200)
            params.setMargins(0, 24, 0, 24)
            layoutParams = params

            setOnClickListener {
                actualizarContenido("Sección: Fotos")
            }
        }



        btnVideo.apply {
            text = ""
            background = ContextCompat.getDrawable(requireContext(), R.drawable.round_button_bg)

            setPadding(0, 50, 0, 0)

            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.video)
            icon?.setBounds(0, 0, 96, 96)
            setCompoundDrawables(null, icon, null, null)

            val params = LinearLayout.LayoutParams(200, 200)
            params.setMargins(0, 24, 0, 24)
            layoutParams = params

            setOnClickListener {
                actualizarContenido("Sección: Video")
            }
        }

        btnWeb.apply {
            text = ""
            background = ContextCompat.getDrawable(requireContext(), R.drawable.round_button_bg)

            setPadding(0, 50, 0, 0)

            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.explorer)
            icon?.setBounds(0, 0, 96, 96)
            setCompoundDrawables(null, icon, null, null)

            val params = LinearLayout.LayoutParams(200, 200)
            params.setMargins(0, 24, 0, 24)
            layoutParams = params

            setOnClickListener {
                actualizarContenido("Sección: Web")
            }
        }

        btnBotones.apply {
            text = ""
            background = ContextCompat.getDrawable(requireContext(), R.drawable.round_button_bg)

            setPadding(0, 50, 0, 0)

            val icon = ContextCompat.getDrawable(requireContext(), R.drawable.menu)
            icon?.setBounds(0, 0, 96, 96)
            setCompoundDrawables(null, icon, null, null)

            val params = LinearLayout.LayoutParams(200, 200)
            params.setMargins(0, 24, 0, 24)
            layoutParams = params

            setOnClickListener {
                actualizarContenido("Sección: Botones")
            }
        }

        view.post {
            actualizarContenido("Sección: Perfil")
        }

        return view
    }

    private fun actualizarContenido(texto: String) {
        val contentFragment = parentFragmentManager.findFragmentById(R.id.contentFragmentContainer) as? ContentFragment
        contentFragment?.actualizarTexto(texto)
    }
}
