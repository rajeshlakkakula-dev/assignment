# Assessment Test
The application should have a total of 3 screens.

Login page – should take an input (username and password) from the user.
list page – on successful login the user should be redirected to this page, where you need to display the data that is returned by the below REST API.
Details page – on click of a list item the app should navigate to a new page which displays the details of the data that the row contains. On this page add a button to capture a photo using the phone camera.
Photo Result page – once the user clicks the photo, please show this page with the image that the user captured, with the timestamp when the photo was captured on the image.
 

To showcase your creativity please think of representing the data using various charts/graphs or on a map. For eg.

Bar Graph – Have a button on the list page which opens a new screen. The new screen should have a Bar graph with the salaries of the first ten employees plotted on it.
Map – Represent the various cities in the response data on a map.
 

The REST API URL is

http://www.checkgaadi.com/reporting/vrm/api/test_new/int/gettabledata.php

The JSON input is

{

                “username”:”test”,

                “password”:”123456”

}
