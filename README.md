# Image Upload API Documentation

## Overview
This API allows users to upload images and receive a response containing the URL of the uploaded image along with its format, height, and width.

## Endpoint
`URL-> https://imageupload-api-6az8.onrender.com/`

`POST-> /api/upload`

### Important Note:
Before making requests to the actual upload endpoint, please ensure that the health check URL is operational and accessible. You can check the health of the API at [https://imageupload-api-6az8.onrender.com/](https://imageupload-api-6az8.onrender.com/). 

Please note that it may take 45-60 seconds for the health check to respond for the first time. Once the health check is confirmed, subsequent requests can be made without any delays.

## Request
- **Method:** POST
- **Headers:**
    - Content-Type: multipart/form-data
- **Body:**
    - `image`: The image file to be uploaded

## Response
Upon successful upload, the API returns a JSON object with the following fields:
- `status`: Indicates the status of the request. Possible values are "success" or "error".
- `image_url`: The URL of the uploaded image.
- `format`: The format of the uploaded image (e.g., jpg, png, etc.).
- `height`: The height of the uploaded image in pixels.
- `width`: The width of the uploaded image in pixels.

### Sample Response
```json
{
    "status": "success",
    "image_url": "https://uploadUrl.jpg",
    "format": "jpg",
    "height": 200,
    "width": 400
}
```

## Error Responses
In case of an error, the API returns a JSON object with a corresponding error message.
```json
{
    "status": "error",
    "message": "Image upload fail!!"
}
```

## Example Usage
```javascript
const formData = new FormData();
formData.append('image', fileInput.files[0]);

fetch('https://imageupload-api-6az8.onrender.com/api/upload', {
  method: 'POST',
  body: formData,
  headers: {
    // No need to set Content-Type, it will be set automatically for FormData
  },
})
.then(response => response.json())
.then(data => {
  console.log('Success:', data);
})
.catch(error => {
  console.error('Error:', error);
});
```

## Note
- Ensure that the image file is included as a multipart form-data in the request body.
- Handle errors appropriately based on the error response returned by the API.