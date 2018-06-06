using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GreenTrafic : MonoBehaviour {

    float time = 0;

    // Use this for initialization
    void Start() {

    }

    // Update is called once per frame
    void Update() {
        Renderer rend = GetComponent<Renderer>();

        time = time + Time.deltaTime;
        if (time > 3) {
            rend.material.color = Color.white;
        } else if (time > 2) {
            rend.material.color = Color.green;
        }
        if (time > 3) {
            time = 0;
        }
    }
}
