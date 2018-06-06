using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RedTraffic : MonoBehaviour {

    float time = 0;

    // Use this for initialization
    void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
        Renderer rend = GetComponent<Renderer>();

        time = time + Time.deltaTime;

        if (time>1) {
            rend.material.color = Color.white;
        }else if (time > 0) {
            rend.material.color = Color.red;
        }

        if (time > 3) {
            time = 0;
        }
    }
}
