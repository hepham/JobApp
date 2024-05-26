package com.example.jobapp.Repository

import com.example.jobapp.Model.JobModel

class MainRepository {
//    all of data in this class is for example, you can use your data with api service
    val location= listOf("LosAngeles","USA","New York","USA")
    val category=listOf("All","Accountant","Programmer","Writter")
    val exampleText:String=
        "We are searching for a talented and motivated this job to join our growing team. In this role, you will be responsible for this job and will be responsible for this job"
    val items= listOf(
        JobModel(
            "UI Designer",
            "ChabokSoft",
            "logo1",
            "Full-time",
            "Remote",
            "Internship",
            "NewYork,USA",
            "\$38K -\$ 46K",
            "2",
            exampleText,
            exampleText
        ),
        JobModel(
        "Acountants",
        "KianSoft",
        "logo2",
        "Full-time",
        "Remote",
        "in person",
        "LosAngeles,USA",
        "\$38K -\$ 46K",
        "2",
        exampleText,
        exampleText
    ),
        JobModel(
            "Developer",
            "TestSoft",
            "logo2",
            "Full-time",
            "Remote",
            "in person",
            "LosAngeles,USA",
            "\$38K -\$ 46K",
            "2",
            exampleText,
            exampleText
        )
    )
}