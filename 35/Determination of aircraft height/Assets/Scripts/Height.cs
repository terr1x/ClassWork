using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Height : MonoBehaviour {

    int maxHeight = 0;

	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update ()
    {
        if (maxHeight < transform.position.y)
        {
            maxHeight = (int)transform.position.y;
        }
        print("Max Height = "+ maxHeight);
	}
}
