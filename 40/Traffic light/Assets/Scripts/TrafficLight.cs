using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class TrafficLight : MonoBehaviour {

    float time = 1;

	// Use this for initialization
	void Start () {
      

	}
	
	// Update is called once per frame
	void Update () {
        Renderer rend = GetComponent<Renderer>();

        time = time + Time.deltaTime;

        if(time >= 1) {
            rend.material.color = Color.red;
        }
        if (time >= 2) {
            rend.material.color = Color.green;
        }
        if (time >= 3) {
            rend.material.color = Color.blue;
        }
        if (time >= 4) {
            rend.material.color = Color.yellow;
            time = 0;
        }
        print(time);
    }
}
