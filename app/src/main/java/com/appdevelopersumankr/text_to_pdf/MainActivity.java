package com.appdevelopersumankr.text_to_pdf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    AppCompatButton save;
    EditText fullname,mobilenumber,email,github,collegename,collegecgpa,interschoolname,interpercentage,tenschoolname,tenpercenatge;
    EditText googledrivelink,firstprojecttopic,secondprojecttopic,thirdprojecttopic,fourthprojecttopic;
    EditText firstprojectdescription,secondprojectdescription,thirdprojectdescription,fourthprojectdescription;
    EditText programminglanguage,alsofamilierwith;
    String name,mobile,email1,github1,college,cgpa,interschool,interper,tenschool,tenper,drivelink,firstp,secondp,thirdp,fourthp;
    String firstpd,secondpd,thirdpd,fourthpd,programming,familier;

    String educationname="EDUCATION";
    String coursename="COURSE";
    String yearname="YEAR";
    String institutename="INSTITUTE";
    String resulname="RESULT";
    String bt="Btech";
    String collegyear="2018-2022";
    String interyear="2018";
    String twelve="12th";
    String ten="10th";
    String tenpassingyear="2016";
    String projectsample="Project Sample Screenshort :--";
    String pro="Project :--";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        save = findViewById ( R.id.buttonid );

        findviewbyidmethod();

        save.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    if (checkSelfPermission ( Manifest.permission.WRITE_EXTERNAL_STORAGE ) == PackageManager.PERMISSION_DENIED) {
                        String[] parmission = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions ( parmission, 1000 );
                    } else savepdf ();
                } else savepdf ();
            }
        } );



    }



    private void savepdf() {
        Document doc = new Document ();
        String mfile = new SimpleDateFormat ( "yyyyMMdd_HHmmss", Locale.getDefault () ).format ( System.currentTimeMillis () );
        String mfilepath = Environment.getExternalStorageDirectory () + "/" + mfile + ".pdf";

        Font bigbigBold = new Font ( Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD, BaseColor.DARK_GRAY );
        Font bigBold = new Font ( Font.FontFamily.TIMES_ROMAN, 20 );
        Font smallBold = new Font ( Font.FontFamily.TIMES_ROMAN, 16 );
        try {
            PdfWriter.getInstance ( doc, new FileOutputStream ( mfilepath ) );
            doc.open ();
            // String mtext = text.getText ().toString ();
            doc.addAuthor ( "suman" );

            extractallstring ();
            // doc.add ( new Paragraph ( mtext, smallBold ) );
            doc.add ( new Paragraph (name,bigbigBold));
            doc.add ( new Paragraph (mobile+"  |  "+email1+"  |  "+github1,smallBold));
            // doc.add ( new Paragraph (email1,smallBold));
            // doc.add ( new Paragraph (github1,smallBold));

            // Education
            //course    year    Institue    result
            doc.add ( new Paragraph (educationname,bigbigBold) );
            doc.add ( new Paragraph (coursename+"     "+yearname+"      "+institutename+"     "+resulname,bigBold) );
            doc.add ( new Paragraph (bt+"     "+collegyear+"    "+college+"    "+cgpa,bigBold));
            // doc.add ( new Paragraph (cgpa,smallBold));
            doc.add ( new Paragraph (twelve+"   "+interyear+"   "+interschool+" "+interper,bigBold));
            //doc.add ( new Paragraph (interper,smallBold));
            doc.add ( new Paragraph (ten+"  "+tenpassingyear+"  "+tenschool+"   "+tenper,bigBold));
            doc.add ( new Paragraph (projectsample,bigBold));
            doc.add ( new Paragraph (drivelink,smallBold));
            doc.add ( new Paragraph (pro,bigBold));
            doc.add ( new Paragraph (firstp,bigBold));
            doc.add ( new Paragraph (firstpd,smallBold));

//            doc.add ( new Paragraph (secondp,bigBold));
//            doc.add ( new Paragraph (secondpd,smallBold));
//            doc.add ( new Paragraph (thirdp,bigBold));
//            doc.add ( new Paragraph (thirdpd,smallBold));
//            doc.add ( new Paragraph (fourthp,bigBold));
//            doc.add ( new Paragraph (fourthpd,smallBold));
            doc.add ( new Paragraph ("Prohramming Language :-"+"    "+programming,bigBold));
            doc.add ( new Paragraph ("Also Familier With :-"+" "+ familier,smallBold));
            doc.close ();
            Toast.makeText ( this, "" + mfile + ".pdf" + " is saved to " + mfilepath, Toast.LENGTH_SHORT ).show ();
        } catch (Exception e) {
            Toast.makeText ( this, "This is Error msg : " + e.getMessage (), Toast.LENGTH_SHORT ).show ();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult ( requestCode, permissions, grantResults );
        switch (requestCode) {
            case 1000:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    savepdf ();
                } else Toast.makeText ( this, "parmission denied..", Toast.LENGTH_SHORT ).show ();
        }
    }

    private void findviewbyidmethod() {
        fullname=findViewById ( R.id.fullnameid);
        mobilenumber=findViewById ( R.id.mobilenumberid);
        email=findViewById ( R.id.emailid);
        github=findViewById ( R.id.githubid);
        collegename=findViewById ( R.id.collegenameid);
        collegecgpa=findViewById ( R.id.cgpaid);
        interschoolname=findViewById ( R.id.interid);
        interpercentage=findViewById ( R.id.interpercentageid);
        tenschoolname=findViewById ( R.id.metricid);
        tenpercenatge=findViewById ( R.id.metricpercentageid);
        googledrivelink=findViewById ( R.id.googledrivelinkid);
        firstprojecttopic=findViewById ( R.id.firstprojectid);
        firstprojectdescription=findViewById ( R.id.firstprojectdescriptionid);
        secondprojecttopic=findViewById ( R.id.secondprojectid);
        secondprojectdescription=findViewById ( R.id.secondprojectdescriptionid);

        programminglanguage=findViewById ( R.id.programminglanguageid);
        alsofamilierwith=findViewById ( R.id.alsofamilierwithid);
    }
    public void extractallstring(){

        name=fullname.getText ().toString ();
        mobile=mobilenumber.getText ().toString ();
        email1=email.getText ().toString ();
        github1=github.getText ().toString ();
        college=collegename.getText ().toString ();
        cgpa=collegecgpa.getText ().toString ();
        interschool=interschoolname.getText ().toString ();
        interper=interpercentage.getText ().toString ();
        tenschool=tenschoolname.getText ().toString ();
        tenper=tenpercenatge.getText ().toString ();
        drivelink=googledrivelink.getText ().toString ();
        firstp=firstprojecttopic.getText ().toString ();
        secondp=secondprojecttopic.getText ().toString ();

        firstpd=firstprojectdescription.getText ().toString ();
        secondpd=secondprojectdescription.getText ().toString ();

        programming=programminglanguage.getText ().toString ();
        familier=alsofamilierwith.getText ().toString ();

    }


}