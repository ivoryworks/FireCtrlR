// Initialize Firebase
function initApp(firebase) {
  var config = {
    apiKey: "apiKey",
    authDomain: "projectId.firebaseapp.com",
    databaseURL: "https://databaseName.firebaseio.com",
    storageBucket: "bucket.appspot.com",
  };
  firebase.initializeApp(config);
}
