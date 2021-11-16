# Stretches for Stresses :)

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
Stretches for Stresses is a mobile application that would encourage and instruct users on daily stretches to increase their flexibility, mood, and/or to try new stretches. 

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category:** Health & Wellness
- **Mobile:** Application is designed for mobile devices
- **Story:** Allows users to explore their flexibility by trying new stretches and encourages them to add stretching to their wellness routine.
- **Market:** Anyone who wants to feel better by destressing and decompressing their bodies would enjoy this app. The opportunity to try a new stretch that leads to a new relief in the body.
- **Habit:** Users can select the body area they would like to focus on, then select the strecth they would like to do. Features like timing how long the user should do the stretch, celebrating milestones on however many stretches they complete, and providing encouraging words after each stretch will support and motivate users to utilize our application daily. Users can explore our library of stretches and decide which they prefer to try. 
- **Scope:** Initially, the application allows you to view different types of stretches. But as the user continues to utilize the app, they gain more milestones and preferred stretches they may want to incorporate into their everyday lives. 

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

- [ ] Create Method to Prompt user with a timer for their stretches
- [ ] Simulate how stretch is to be preformed
- [ ] Milestone feature for when users complete a certain amount of stretches
- [ ] Add motivation/encouraging quote of the day 
- [ ] User can swipe to next stretch in app
- [ ] User can select which area of the body they'd like to stretch
- [x] User can Log into and logout of app
- [x] User can Sign-up to app
- [ ] Chime when open
- [ ] Repository to view the previous stretches

**Optional Nice-to-have Stories**

- [ ] Display the day of the week
- [ ] Skill levels ex. Beginner, Intermediate, Advanced
- [ ] Blog, Areas for articles

### 2. Screen Archetypes

* Home (Detail Archetype)
    * Stretch of the day 
    * Navigation to Stretch catalog
    * Quote of the Day
* Login/ Register Archetype
    * User can login
    * User can register for a new account
* Catalog (Stream Archetype)
    * User can selected body focus area 
    * User can scroll through Stretch Catalog and select stretch
 * Milestone (Detail Archetype)
    * User can view goals, previously completed stretches, and number of completed stretches
* Profile (Creation/Settings Archetypes)
    * User can view their email and password
    * User can edit their email and password
    * User can logout
    * User can redirect to milestones to check their progress
    * User can access their settings from the profile

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home
* Stretch Catalog
* Profile
* Milestones

**Flow Navigation** (Screen to Screen)

* Login Screen
   * Home Page
* Registration Screen
   * Home Page
* Stream Screen
   * Individual stretch activity (from catalog)
* Profile
    * Settings

## Wireframes
<img src="https://github.com/REM-Seminar/Stretches-For-Stresses/blob/main/Seminar_Wireframe.jpg" width=600>


## Schema 
### Models
**Home View**
| Property           | Type    | Description                              |
| ------------------ | ------- | ---------------------------------------- |
| welcome_message    | String  | Displays a welcome message to the user   |
| quote_of_the_day   | String  | Displays the quote of the day            |
| stretch_of_the_day | Post    | Displays the selected stretch of the day |
| stretch_catalog    | Pointer | Sends user to stretch catalog            |


**Catalog Screen(1)**
| Property  | Type       | Description |
| --------- | ---------- | ----------- |
| Full Body          |     Point to Catalog (2) Full Body Array       |         Full body button that takes you to full body array    |
|          Lower Body |      Point to Catalog (2) Lower Body Array      |     Lower Body button that takes you to Lower Body array        |
|     Upper Body      |      Point to Catalog (2) Upper Body Array      |       Upper body button that takes you to upper body array      |
| Back | Point to Catalog (2)  Back Array | Back button that takes you to back array        |


**Catalog Screen(2)**
|Property|Type|Description|
| --------- | ---------- | ----------- |
|stretch_id|Array|Id linked to stretch from database to display in stretch catalog
stretch_focus|Array|Stretch focus group ex. Full body(FB), Upperbody (UB), etc
stretch_images|File|Image/video for stretch, uploaded and pulled from existing database
description|String|Details on how to perform stretch 
timer_duration|Number|How long the stretch is recommended to be done for
stretch_completed|Number|User takes action on complete button to earn stars


**Milestones**
|Property|Type|Description|
| --------- | ---------- | ----------- |
#_of_stretches_completed|Number|Number of stretches the user has completed in total
stretches_in_type_completed|Number|Display the type of stretches the user has completed
user_goals|String|User goal shown from profile


**Profile**
|Property|Type|Description|
| --------- | ---------- | ----------- |
profile_greeting|Array|Greeting for user when they enter the profile page
user_email|String|String for user email
user_password|String|String for user password
edit_text|String|Clickable to edit user email/password
milestones_link|Pointer to Milestone|Clicking text takes you to milestone pages
logout_button|Button|Button that logs user out




### Networking
**List of network requests by screen**
* Signup/Login Screen
    * (Create/POST) Create a new user
* Milestone Screen
    * (Update/PUT) Update user goals
* Catalog Screen (1) / Body Focus Area
    * (Read/GET) Fetching user's preferred body area stretches
* Catalog Screen (2) / Stretches 
    * (Read/GET) Fetching user's selected stretch
* Profile Screen
    * (Update/PUT) Update user email and password

### Parse Query Code
**(Create/POST) Create a new user**
```
let query = PFUser(className:"newUser")
user_email = "email@example.com"
user_password = "myPassword"
newUser.signUpInBackground { (succeeded: Bool, error: Error?) in
   if let error = error {
      print(error.localizedDescription)
   } else {
      print("Successfully created new user.")
   }
}
```
**(Update/PUT) Update user goals**
```
let query = PFQuery(className:"userGoals")
query.getObjectInBackground (withId:"elemenop") {goals: [PFObject]?, error: Error?) in
   if let error = error {
      print(error.localizedDescription)
   } else if let goals = goals {
      goals["goal"] = new.goals
      print("Successfully updated your goals.")
   }
}

```

**(Read/GET) Fetching user's preferred body area stretches**
```
let query = PFQuery(className:"TargetBody")
query.order(byDescending: "alphabetically")
query.findObjectsInBackground { (targetAreas: [PFObject]?, error: Error?) in
   if let error = error {
      print(error.localizedDescription)
   } else if let targetAreas = targetAreas {
      print("Successfully retrieved \(targets.count) targeted body area.")
      // TODO: Do something with posts...
   }
}

```
**(Read/GET) Fetching user's selected stretch**
```
let query = PFQuery(className:"Stretch")
query.order(byDescending: "alphabetically")
query.findObjectsInBackground { (stretches: [PFObject]?, error: Error?) in
   if let error = error {
      print(error.localizedDescription)
   } else if let stretches = stretches {
      print("Successfully retrieved \(stretches.count) stretch.")
      // TODO: Do something with posts...
   }
}

```
**(Update/PUT) Update user email and password**
```
PFUser.requestPasswordResetForEmail(inBackground: "email@example.com")

let query = PFQuery(className:"userEmail")
query.getObjectInBackground (withId:"nIdwka") {email: [PFObject]?, error: Error?) in
   if let error = error {
      print(error.localizedDescription)
   } else if let email = email {
      email["Email"] = new.email
      print("Successfully updated your goals.")
   }
}

```

## Progress Gifs
### Splash Screen 
<img src="https://github.com/REM-Seminar/Stretches_For_Stresses/blob/master/s4s.gif" width=600>
