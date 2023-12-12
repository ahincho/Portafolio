package com.unsa.persistence.data.providers

import com.unsa.persistence.data.model.Applicant

class ApplicantProvider {
    companion object {
        var applicants: MutableList<Applicant> = mutableListOf(
            Applicant(1, "32609362", "Trudey", "Dalman", "02/06/2000", "Meadowbrook Elementary School", "Business Development"),
            Applicant(2, "12160424", "Moyna", "Blabey", "23/06/2001", "Maplewood High School", "Accounting"),
            Applicant(3, "42607122", "Dore", "Bassano", "07/01/2001", "Pinecrest Academy", "Engineering"),
            Applicant(4, "43101510", "Barney", "Bucktharp", "27/04/2002", "Meadowbrook Elementary School", "Product Management"),
            Applicant(5, "60387536", "Nadine", "Sellen", "22/08/2004", "Ivy League High School", "Product Management"),
            Applicant(6, "12672877", "Guglielmo", "Di Biasi", "12/05/2005", "Oakridge Preparatory School", "Marketing"),
            Applicant(7, "75957614", "Delphine", "de Keyser", "15/08/2000", "Lakeside Junior High", "Marketing"),
            Applicant(8, "21525168", "Rodney", "Beardwell", "07/05/2001", "Riverside Elementary", "Human Resources"),
            Applicant(9, "39508826", "Cleo", "Henmarsh", "07/02/2001", "Harmony International School", "Sales"),
            Applicant(10, "32057619", "Cam", "Feaster", "25/03/2004", "Crestwood Middle School", "Engineering"),
            Applicant(11, "15179832", "Denny", "Mighele", "26/02/2003", "Lakeside Junior High", "Marketing"),
            Applicant(12, "58045580", "Ferdinand", "Duiged", "13/07/2002", "Riverside Elementary", "Support"),
            Applicant(13, "22878298", "Ardine", "Wolfenden", "25/08/2002", "Ivy League High School", "Legal"),
            Applicant(14, "32918936", "Melamie", "Ibbotson", "06/01/2004", "Crestwood Middle School", "Human Resources"),
            Applicant(15, "79341302", "Sissy", "Fardon", "09/10/2002", "Pinecrest Academy", "Legal"),
            Applicant(16, "93477009", "Jordon", "McGaffey", "27/12/2003", "Summit Academy", "Product Management"),
            Applicant(17, "67778969", "Ame", "Macak", "29/12/2003", "Oakridge Preparatory School", "Human Resources"),
            Applicant(18, "28335253", "Murial", "Igglesden", "06/04/2005", "Meadowbrook Elementary School", "Marketing"),
            Applicant(19, "19923672", "Alberik", "Yosevitz", "12/10/2000", "Harmony International School", "Training"),
            Applicant(20, "32053695", "Odetta", "Rayworth", "10/01/2005", "Crestwood Middle School", "Sales"),
            Applicant(21, "80141768", "Aubine", "Whiten", "16/10/2000", "Riverside Elementary", "Support"),
            Applicant(22, "18580225", "Weston", "Prium", "16/10/2003", "Meadowbrook Elementary School", "Engineering"),
            Applicant(23, "35010238", "Shelley", "Graham", "26/09/2001", "Meadowbrook Elementary School", "Engineering"),
            Applicant(24, "43297482", "Katya", "Andriveaux", "29/05/2001", "Summit Academy", "Product Management"),
            Applicant(25, "68457589", "Dur", "Stops", "25/06/2003", "Riverside Elementary", "Engineering")
        )
    }
}