using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class YellowTraffic : MonoBehaviour {

    float time = 0;

    // Use this for initialization
    void Start() {

    }

    // Update is called once per frame
    void Update() {
        Renderer rend = GetComponent<Renderer>();

        time = time + Time.deltaTime;
        if (time > 2) {
            rend.material.color = Color.white;
        } else if (time > 1) {
            rend.material.color = Color.yellow;
        }
        if (time > 3) {
            time = 0;
        }
    }
}