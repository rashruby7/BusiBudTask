<?php

$ch = curl_init('https://coderbyte.com/api/challenges/json/age-counting');
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HEADER, 0);
$data = curl_exec($ch);
curl_close($ch);

// Parse the response as JSON
$dataArray = json_decode($data, true);

// Extract the value of the 'data' key
$dataString = $dataArray['data'];

// Split the data string into individual items
$items = explode(', ', $dataString);

// Count the items with age equal to or greater than 50
$count = 0;
foreach ($items as $item) {
    // Extract the age value from each item
    $age = substr($item, strpos($item, 'age=') + 4);

    // Check if the age is equal to or greater than 50
    if ((int)$age >= 50) {
        $count++;
    }
}

// Print the final count
echo $count;

?>
