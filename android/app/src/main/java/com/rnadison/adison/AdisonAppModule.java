package com.rnadison.adison;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import co.adison.offerwall.Adison;
import co.adison.offerwall.AdisonConfig;
import co.adison.offerwall.Gender;
import co.adison.offerwall.Server;

public class AdisonAppModule extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;
    private static String PUB_APP_KEY = "";

    public AdisonAppModule(ReactApplicationContext reactContext){
        super(reactContext);
        this.reactContext = reactContext;

        Adison.initialize(this.reactContext, "com.rnadison");
        Adison.setServer(Server.Development);
        //Adison.setDebugEnabled(true);
    }

    /**
     * Module Name
     *
     * @return
     */
    @Override
    public String getName(){
        return "AdisonAppModule";
    }

    /**
     * Adison Config Setting
     *
     * @param title
     */
    @ReactMethod
    public void setConfig(Boolean isPrepareView, Boolean isInfoBar, String title){
        AdisonConfig config = new AdisonConfig();
        config.setPrepareViewHidden(isPrepareView);  // 스플래시 숨김 (기본값: false)
        config.setInfoBarHidden(isInfoBar);  // 상단 정보창 숨기 (기본값: false)
        config.setOfferwallListTitle(title);  // 목록화면 네비게이션 타이틀 (기본값: 오퍼월)

        Adison.setConfig(config);
    }

    /**
     * Adison uid Setting
     * @param uid
     */
    @ReactMethod
    public void setUid(String uid){
        Adison.setUid(uid);
    }

    /**
     * Adison BirthYear Setting
     *
     * @param birthYear int : 2000
     */
    @ReactMethod
    public void setBirthYear(int birthYear){
        Adison.setBirthYear(birthYear);
    }

    /**
     * Adison Gender Setting
     * default FEMALE
     *
     * @param gender
     */
    @ReactMethod
    public void setGender(String gender){
        if(gender.indexOf("UNKNOWN") != -1){
            Adison.setGender(Gender.UNKNOWN);
        }else if(gender.indexOf("MALE") != -1){
            Adison.setGender(Gender.MALE);
        }else{
            Adison.setGender(Gender.FEMALE);
        }
    }


    /**
     * Adison OfferWall Call
     */
    @ReactMethod
    public void showOfferwall(){
        Adison.showOfferwall();
    }
}