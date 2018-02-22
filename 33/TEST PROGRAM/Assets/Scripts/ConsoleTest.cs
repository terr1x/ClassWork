using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ConsoleTest : MonoBehaviour {

	// Use this for initialization
	void Start () {
    }

    // Update is called once per frame
    void Update () {
        print("x = " + transform.position.x + " y = " + transform.position.y + " z = "+transform.position.z);
	}
}
