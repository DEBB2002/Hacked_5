package com.example.hacked;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Places extends AppCompatActivity {
String place;
TextView placeName,About;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_places );
       place=getIntent().getStringExtra( "Name" );
       About=findViewById( R.id.infotxt );
       placeName=findViewById( R.id.place_Name );
       placeName.setText( place );
       if(place.equals(  "Yamunotri"))
       {
           About.setText( "Yamunotri, also Jamnotri, is the source of the Yamuna River and the seat of the Goddess Yamuna in Hinduism. It is situated at an altitude of 3,293 metres (10,804 ft) in the Garhwal Himalayas and located approximately 150 kilometers (93 mi) North of Uttarkashi, the headquarters of the Uttarkashi district in the Garhwal Division of Uttarakhand, India. It is one of the four sites in India's Chhota Char Dham pilgrimage.\nIt is the source of River Yamuna and the abode of Goddess Yamuna. Famous for its thermal springs and glaciers, Yamunotri is located in Uttarkashi District of Uttarakhand. Yamuna originates from the Champasar Glacier, which is located below Banderpoonch peak.\n " );
       }
       else if(place.equals( "Gangotri"))
       {
           About.setText( "Gangotri is a town and a Nagar Panchayat (municipality) in Uttarkashi district in the state of Uttarakhand, India. It is 99 km from Uttarkashi, the main district headquarter. It is a Hindu pilgrim town on the banks of the river Bhagirathi – the origin of the river Ganges. The town is located on the Greater Himalayan Range, at a height of 3,100 metres (10,200 ft). According to popular Hindu legend, Goddess Ganga descended here when Lord Shiva released the mighty river from the locks of his hair.\n The origin place for the most sacred river on earth, Gangotri is a must visit for the religious folks as well as the explorers. Situated amongst the most scenic of locations – Gangotri offers something for everyone." +
                   "\n" );
       }
        else if(place.equals("Kedarnath"))
       {
           About.setText("Kedarnath is a town in Rudraprayag district in the state of Uttarakhand in India and has gained importance because of the Kedarnath Temple. It is approximately 86 kilometres from Rudraprayag, the district headquarter. It is a Nagar panchayat in the Rudraprayag district.\n Tourists will find several shops selling souvenirs, photographs of Kedarnath, Badrinath and other gods. Genuine Rudraksh, which is an important part of Hindu rituals, can also be bought here. Crystals, Saligrams, herbs like Shilajit, precious stones and Tulsi beads are other things which can be purchased here.\n");

       }
        else if(place.equals("Badrinath"))
       {About.setText( "Badrinath is a town and nagar panchayat in Chamoli district in the state of Uttarakhand, India. A Hindu holy place, it is one of the four sites in India's Char Dham pilgrimage and is also part of India's Chota Char Dham pilgrimage circuit. It gets its name from the Badrinath Temple.\n The ancient Hindu temple is known to be the source of the holy Alaknanda River and as per religious beliefs, visiting the temple washes away all the sins of a person and helps them in attaining moksha. Here is a complete guide to the famous Badrinath Temple that will help you plan your trip.\n" );

       }
    }
}