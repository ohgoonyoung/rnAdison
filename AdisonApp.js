import { NativeModules } from 'react-native';

const AdisonApp = function() {
  this.AdisonAppModule = NativeModules.AdisonAppModule;

  this.checkModule = function(){
    if(this.AdisonAppModule === null) return;
  }
/**
 * @description 오퍼월 실행
 */
  this.showOfferWall = function(){
    try{
      this.checkModule();

      this.AdisonAppModule.showOfferwall();
    }catch(err){
    }
  }

  /**
   * @description Adison Config Setting
   * @param {boolean} isPrepareView 스플래시 숨김 (기본값: false)
   * @param {bool} isInfoBar 상단 정보창 숨기 (기본값: false)
   * @param {string} title 목록화면 네비게이션 타이틀 (기본값: 오퍼월)
   */
  this.setConfig = function(isPrepareView = false, isInfoBar = false, title = "오퍼월"){
    try{
      this.checkModule();

      this.AdisonAppModule.setConfig(isPrepareView, isInfoBar, title);
    }catch(err){
    }
  }

  /**
   * @description Adison Uid Setting
   * @param {string} uid
   */
  this.setUid = function(uid = ""){
    try{
      this.checkModule();

      this.AdisonAppModule.setUid(uid);
    }catch(err){}
  }

  /**
   * @description Adison BirthYear Setting
   * @param {int} birthYear 2000
   */
  this.setBirthYear = function(birthYear = 2000){
    try{
      this.checkModule();

      this.AdisonAppModule.setBirthYear(birthYear);
    }catch(err){}
  }

  /**
   * @description Adison Gender Setting
   * @param {string} gender UNKNOWN | MALE | FEMALE
   */
  this.setGender = function(gender = "FEMALE"){
    try{
      this.checkModule();

      this.AdisonAppModule.setGender(gender);
    }catch(err){}
  }
};

export default new AdisonApp();