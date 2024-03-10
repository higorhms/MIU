const GIFEncoder = require('gif-encoder-2');
const { createCanvas, Image } = require('canvas');
const { createWriteStream } = require('fs');
const path = require('path');

// Your specified image paths
const imagePaths = [
  path.join(__dirname, "fall.jpg"),
  path.join(__dirname, "spring.jpg")
];

function loadImage(src) {
  return new Promise((resolve, reject) => {
    const img = new Image();
    img.onload = () => resolve(img);
    img.onerror = (err) => reject(err);
    img.src = src;
  });
}

async function createGif(algorithm, imagePaths) {
  // Load the first image to determine the width and height for the GIF
  const firstImage = await loadImage(imagePaths[0]);
  const width = firstImage.width;
  const height = firstImage.height;

  const encoder = new GIFEncoder(200, 200, algorithm);
  const dstPath = path.join(__dirname, `output-${algorithm}.gif`);
  const writeStream = createWriteStream(dstPath);
  encoder.createReadStream().pipe(writeStream);

  encoder.start();
  encoder.setDelay(500); // Set the frame delay to 500ms

  const canvas = createCanvas(200, 200);
  const ctx = canvas.getContext('2d');

  // Draw each image and add it as a frame to the encoder
  for (const imagePath of imagePaths) {
    const frame = await loadImage(imagePath);
    ctx.drawImage(frame, 0, 0, 200, 200);
    encoder.addFrame(ctx);
  }

  encoder.finish();
  writeStream.on('finish', () => {
    console.log(`GIF created using ${algorithm} algorithm.`);
  });
}

// Run the GIF creation function for each algorithm
createGif('neuquant', imagePaths).catch(console.error);
// createGif('octree', imagePaths).catch(console.error);
