﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Timer : MonoBehaviour {

    float time = 0;

    // Use this for initialization
    void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
        time = time + Time.deltaTime;
        if (time > 15)
        {
            transform.position = new Vector3(-1,1,6);
            time = 0;
        }
    }
}
