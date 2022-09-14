## Talgud
 "Talgud" on Vali-IT kursuse meeskonnaprojekt (backend), mis muudab lihtsamaks talgute planeerimist ja vajalike resursside korraldamist. Soovija saab liituda eesolevate talgutega ning valida omale vastutamiseks meelepärase töölõigu. Samuti saab vaadata juba möödunud talgudel tehtud töid. 

#### Running locally

``./gradlew run``



#### Running in docker

``docker build -t talgud-back .``

``docker run -dp 8080:8080 talgud-back``

