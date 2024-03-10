const GIFEncoder = require('gifencoder');
const Jimp = require('jimp');
const fs = require('fs');
const path = require('path');

// Your specified image paths
const imagePaths = [
  path.join(__dirname, "fall.jpg"),
  path.join(__dirname, "spring.jpg")
];

async function createGif(imagePaths) {
  // Load the first image to determine the width and height for the GIF
  const firstImage = await Jimp.read(imagePaths[0]);
  const { width, height } = firstImage.bitmap;

  const encoder = new GIFEncoder(width, height);
  encoder.start();
  encoder.setRepeat(0); // 0 for no repeat, -1 for infinite loop
  encoder.setDelay(500); // Frame delay in milliseconds
  encoder.setQuality(10); // Image quality. 1 (best) to 20 (worst)

  for (const imagePath of imagePaths) {
    const image = await Jimp.read(imagePath);
    // Resize the image to the width and height of the first image if necessary
    image.resize(width, height);
    encoder.addFrame(image.bitmap.data);
  }

  encoder.finish();

  // Save the GIF
  const buffer = encoder.out.getData();
  fs.writeFileSync(path.join(__dirname, 'output.gif'), buffer);
  console.log('GIF created successfully');
}

createGif(imagePaths).catch(console.error);
