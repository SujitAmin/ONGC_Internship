package ongcphonebook.com.ongctelephone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {

    TextView Design;
    String Designation;
    TextView Locate;
    String Location;
    String Mobile;
    TextView Nam;
    String Name;
    //  String Office;
    String Office_tel;
    // String SubOffice;
    //  String city;
    TextView cpfee;
    String mail;
    TextView mobbii;
    // TextView offi;
    //   TextView subof;
    TextView tellee;

 /*  void addContact(Context context)
      {
          String string2;
      }*/


    Button button_email, button_sms, button_mobile, button_telephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = this.getIntent();
        this.Name = intent.getStringExtra("Name");
        this.setTitle(this.Name);
        this.Location = intent.getStringExtra("Location");
        this.Designation = intent.getStringExtra("Designation");
        //this.Office = intent.getStringExtra("Office");
        //  this.SubOffice = intent.getStringExtra("SubOffice");
        this.Office_tel = intent.getStringExtra("Office-Tel");
        this.Mobile = intent.getStringExtra("Mobile");
        this.mail = intent.getStringExtra("mail");
        //  this.city = intent.getStringExtra("City");
        button_email = (Button) findViewById(R.id.button_email);
        button_sms = (Button) findViewById(R.id.button_sms);
        button_mobile = (Button) findViewById(R.id.button_mobile);
        button_telephone = (Button) findViewById(R.id.button_telephone);


        this.Nam = (TextView) this.findViewById(R.id.Nam);
        this.Locate = (TextView) this.findViewById(R.id.Locate);
        this.Design = (TextView) this.findViewById(R.id.Designs);
        this.mobbii = (TextView) this.findViewById(R.id.mobii);
        this.tellee = (TextView) this.findViewById(R.id.tellee);
        this.cpfee = (TextView) this.findViewById(R.id.ccc);
        if (this.Name.equals("--")) {
            this.Nam.setText("-");
        } else {
            this.Nam.setText(this.Name);
        }
     /*   if (this.city.equals((Object) "--")) {
            this.Locate.setText((CharSequence) "-");
        } else {
            this.Locate.setText((CharSequence) (String.valueOf((Object) this.city) + "\n"));
        }*/
        if (this.Location.equals("--")) {
            this.Locate.setText(" ");
        } else {
            this.Locate.setText(this.Locate.getText() + this.Location + ", ");
        }
       /* if (this.Office.equals((Object) "--")) {
            this.Locate.setText((CharSequence) ((Object) this.Locate.getText() + " "));
        } else {
            this.Locate.setText((CharSequence) ((Object) this.Locate.getText() + this.Office + ", "));
        }*/
      /*  if (this.SubOffice.equals((Object) "--")) {
            this.Locate.setText((CharSequence) ((Object) this.Locate.getText()));
        } else {
            this.Locate.setText((CharSequence) ((Object) this.Locate.getText() + this.SubOffice));
        }*/
        if (this.Designation.equals("--")) {
            this.Design.setText(" ");
        } else {
            this.Design.setText("Designation :\n" + this.Designation);
        }
        if (this.Mobile.equals("--")) {
            this.mobbii.setText(" ");
        } else {
            this.mobbii.setText("Mobile :\n" + this.Mobile);
        }
        if (this.Office_tel.equals("--")) {
            this.tellee.setText(" ");
        } else {
            this.tellee.setText("TelePhone No. :\n022-" + this.Office_tel);
        }
        if (this.mail.equals("--")) {
            this.cpfee.setText(" ");
            return;
        }
        this.cpfee.setText("E-Mail I.D :\n" + this.mail + "@ongc.co.in");

        this.button_mobile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Details.this.Mobile.equals("--")) {
                    Toast.makeText(Details.this.getApplicationContext(), "No Mobile No. Found", 1).show();
                    return;
                }
                if (Details.this.Mobile.replace("-", "").length() == 10) {
                    Intent intent = new Intent("android.intent.action.CALL");
                    intent.setData(Uri.parse("tel:" + Details.this.Mobile));
                    Details.this.startActivity(intent);
                    return;
                }
                if (Details.this.Mobile.replace("-", "").length() == 8) {
                    Intent intent = new Intent("android.intent.action.CALL");
                    intent.setData(Uri.parse("tel:022" + Details.this.Mobile));
                    Details.this.startActivity(intent);
                    return;
                }
                Toast.makeText(Details.this.getApplicationContext(), "Invalid Phone Number", 0).show();
            }
        });
        this.button_telephone.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (Details.this.Office_tel.equals("--")) {
                    Toast.makeText(Details.this.getApplicationContext(), "No Telephone No. Found", 1).show();
                    return;
                }
                if (Details.this.Office_tel.replace("-", "").length() == 10) {
                    Intent intent = new Intent("android.intent.action.CALL");
                    intent.setData(Uri.parse("tel:" + Details.this.Office_tel));
                    Details.this.startActivity(intent);
                    return;
                }
                if (Details.this.Office_tel.replace("-", "").length() == 8) {
                    Intent intent = new Intent("android.intent.action.CALL");
                    intent.setData(Uri.parse("tel:022" + Details.this.Office_tel));
                    Details.this.startActivity(intent);
                    return;
                }
                Toast.makeText(Details.this.getApplicationContext(), "Invalid Phone Number\n" + Details.this.Office_tel, 0).show();
            }
        });


        button_sms.setOnClickListener(new View.OnClickListener() {

            //  sendSMS();
            public void onClick(View view) {
                if (Details.this.Mobile.equals("null")) {
                    Toast.makeText(Details.this.getApplicationContext(), "No Mobile No. Found", 1).show();
                    return;
                }
                Details.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("sms:" + Details.this.Mobile)));
            }


        });
        button_email.setOnClickListener(new View.OnClickListener() {

            //sendEmail();
            public void onClick(View view) {
                if (Details.this.mail.equals("--")) {
                    Toast.makeText(Details.this.getApplicationContext(), "No Email I.D Found", 1).show();
                    return;
                }
                Intent intent = new Intent("android.intent.action.SEND");
                String[] arrstring = new String[]{String.valueOf(Details.this.mail) + "@ongc.co.in"};
                intent.putExtra("android.intent.extra.EMAIL", arrstring);
                intent.setType("message/rfc822");
                Details.this.startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }


        });

    }
}

