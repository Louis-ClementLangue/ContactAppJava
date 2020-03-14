package export;

import typeData.Person;

import java.io.File;
import java.io.FileWriter;

public class VCard {

    private Person person;
    private String nameFolder;
    private FileWriter file;

    public VCard(Person person){
        this.person = person;
        nameFolder = person.getLastname() + "_" + person.getFirstname() + ".vcf";
    }

    public boolean exportFile(){
        String n = "";
        String fn = "";
        String nickname = "";
        String tel = "";
        String email = "";
        String adr = "";
        if (!person.getLastname().equals("") && !person.getFirstname().equals("")){
            n = "N:" + person.getLastname() +";" + person.getFirstname() +";;;\n";
            fn = "FN:" + person.getLastname() + person.getFirstname() + "\n";
        }else if(person.getLastname().equals("") && !person.getFirstname().equals("")){
            n = "N:" + person.getFirstname() +";;;\n";
            fn = "FN:" + person.getLastname() + person.getFirstname() + "\n";
        }else if(!person.getLastname().equals("") && person.getFirstname().equals("")){
            n = "N:" + person.getLastname() +";;;\n";
            fn = "FN:" + person.getLastname() + person.getFirstname() + "\n";
        }

        if (!person.getNickname().equals("")){
            nickname = "NICKNAME:" + person.getNickname() + "\n";
        }

        if (!person.getPhoneNumber().equals("")){
            tel = "TEL;TYPE=home,voice;VALUE=uri:tel:" + person.getPhoneNumber() + "\n";
        }

        if (!person.getEmailAddress().equals("")){
            email = "EMAIL:" + person.getEmailAddress() + "\n";
        }

        if (!person.getAdress().equals("")){
            adr = "ADR;TYPE=home:" + person.getAdress() + "\n";
        }

        String fileContent = "BEGIN:VCARD\n" +
                "VERSION:4.0\n" +
                n +
                fn +
                nickname +
                tel +
                email+
                adr+
                "END:VCARD";
        try {
            file = new FileWriter(this.nameFolder);
            file.write(fileContent);
            file.flush();
            file.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
