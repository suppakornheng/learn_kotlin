package com.developerthai.ch14fragmentui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class InfoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, bundle: Bundle?) {
        val name = view.findViewById<EditText>(R.id.editText_name);
        val address = view.findViewById<EditText>(R.id.editText_address);

        view.findViewById<Button>(R.id.button_info_ok).apply {
            setOnClickListener {
                var msg = "ขอบคุณค่ะ"
                val n = name.getText().toString().trim()
                val a = address.getText().toString().trim()
                if (n.isEmpty() || a.isEmpty()) {
                    msg = "กรุณากำหนดข้อมูลให้ครบด้วยค่ะ"
                }
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            }
        }
    }

}
