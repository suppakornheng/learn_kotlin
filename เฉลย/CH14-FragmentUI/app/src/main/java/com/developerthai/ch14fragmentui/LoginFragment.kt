package com.developerthai.ch14fragmentui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, bundle: Bundle?) {
        val email = view.findViewById<EditText>(R.id.editText_email);
        val password = view.findViewById<EditText>(R.id.editText_password);

        view.findViewById<Button>(R.id.button_login_ok).apply {
            setOnClickListener {
                var msg = "ขอบคุณค่ะ"
                val e = email.getText().toString().trim()
                val p = password.getText().toString().trim()
                if (e.isEmpty() || p.isEmpty()) {
                    msg = "กรุณากำหนดข้อมูลให้ครบด้วยค่ะ"
                }
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
