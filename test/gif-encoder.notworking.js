const GIFEncoder = require('gif-encoder-2');
const sharp = require('sharp');
const { createWriteStream } = require('fs');
const path = require('path');
const fs = require('fs');

// Your specified image paths
const imagePaths = [
  path.join(__dirname, "fall.jpg"),
  path.join(__dirname, "spring.jpg")
];

async function createGif(algorithm, imagePaths) {
  // Use sharp to get the dimensions of the first image
  const { width, height } = await sharp(imagePaths[0]).metadata();

  const encoder = new GIFEncoder(width, height, algorithm);
  const dstPath = path.join(__dirname, `output-${algorithm}.gif`);
  const writeStream = createWriteStream(dstPath);
  encoder.createReadStream().pipe(writeStream);

  encoder.start();
  encoder.setDelay(500); // Set the frame delay to 500ms

  for (const imagePath of imagePaths) {
    try {
      await sharp(imagePath)
        .resize(width, height)
        .toFile(dstPath);

      // Now read the file from disk
      fs.readFile(dstPath, (fileData) => {
        encoder.addFrame(fileData);
      });
    } catch (err) {
      console.error('Error processing image:', imagePath, err);
    }
  }

  encoder.finish();
  writeStream.on('finish', () => {
    console.log(`GIF created using ${algorithm} algorithm.`);
  });
}

// Run the GIF creation function for each algorithm
createGif('neuquant', imagePaths).catch(console.error);
