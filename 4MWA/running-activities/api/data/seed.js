const activities = [
  // previous activities
  //...
  {
    name: "Recovery Runs",
    description: "Recovery runs are done at an easy pace, following a hard workout or race. The goal is to aid recovery by stimulating blood flow and loosening up your muscles.",
    duration: "20-30 minutes",
    benefits: [
      {
        name: "Improved Recovery",
        description: "Recovery runs stimulate blood flow to the muscles, helping to speed up the recovery process after a hard workout."
      },
      {
        name: "Injury Prevention",
        description: "Recovery runs allow you to continue training without placing too much additional stress on your muscles and joints."
      }
    ]
  },
  {
    name: "Progression Runs",
    description: "Progression runs start at an easy pace, then gradually speed up to a moderate or hard pace towards the end. They're a great way to build stamina and teach your body to finish strong.",
    duration: "30-60 minutes",
    benefits: [
      {
        name: "Increased Stamina",
        description: "Progression runs build stamina by training your body to run faster when it's already tired."
      },
      {
        name: "Mental Strength",
        description: "Learning to push through fatigue and finish a run strong can also help improve your mental strength and resilience."
      }
    ]
  },
  {
    name: "Speed Runs",
    description: "Speed runs are shorter workouts designed to increase your maximum running speed. They typically involve intervals run at a fast pace, with short recovery periods in between.",
    duration: "20-30 minutes",
    benefits: [
      {
        name: "Speed Development",
        description: "Speed runs develop your fast-twitch muscle fibers and help improve your maximum running speed."
      },
      {
        name: "Improved Running Economy",
        description: "Speed work can also improve your running economy, allowing you to use less energy at any given pace."
      }
    ]
  },
  {
    name: "Race-Pace Runs",
    description: "Race-pace runs are workouts done at your goal race pace. They help your body and mind get used to the pace you aim to run in your race.",
    duration: "Varies based on race distance",
    benefits: [
      {
        name: "Pace Familiarity",
        description: "Race-pace runs help you get a feel for your goal race pace, making it easier to maintain that pace on race day."
      },
      {
        name: "Race Preparation",
        description: "Running at your race pace helps simulate race conditions and prepare you for the mental and physical challenges of the race."
      }
    ]
  },
  {
    name: "Base Run",
    description: "Base runs are short to moderate-length runs undertaken at a runner's natural pace. These runs form the foundation of any running routine.",
    duration: "20-60 minutes",
    benefits: [
      {
        name: "Aerobic Fitness",
        description: "Regular base running builds your aerobic fitness, improving cardiovascular health and stamina."
      },
      {
        name: "Establish Routine",
        description: "Base runs help establish a regular running routine and develop the habit of running."
      }
    ]
  },
  {
    name: "Long Run",
    description: "Long runs are typically the longest run of the week, done at a steady, sustainable pace. They help build endurance and mental toughness.",
    duration: "60+ minutes",
    benefits: [
      {
        name: "Increased Endurance",
        description: "Long runs increase your endurance and stamina, allowing you to run longer distances."
      },
      {
        name: "Mental Toughness",
        description: "The extended duration of long runs develops mental strength and resilience."
      }
    ]
  },
  {
    name: "Interval Run",
    description: "Interval runs involve periods of intense effort interspersed with periods of moderate to light effort. This training method improves speed and cardiovascular fitness.",
    duration: "20-40 minutes",
    benefits: [
      {
        name: "Improved Cardiovascular Fitness",
        description: "Interval runs enhance your VO2 max, helping your body to use oxygen more efficiently."
      },
      {
        name: "Increased Speed",
        description: "The high-intensity periods in interval running boost your running speed."
      }
    ]
  },
  {
    name: "Hill Run",
    description: "Hill runs involve running uphill to build strength and power. The incline makes your body work harder, yielding muscular and cardiovascular benefits.",
    duration: "30-60 minutes",
    benefits: [
      {
        name: "Increased Leg Strength",
        description: "Hill running strengthens the leg muscles, enhancing your power and speed."
      },
      {
        name: "Improved Running Economy",
        description: "Hill running develops better form and efficiency, which can lead to improved performance."
      }
    ]
  },
  {
    name: "Tempo Run",
    description: "Tempo runs, also known as threshold runs, are done at a “comfortably hard” pace that is just outside your comfort zone. They are designed to increase your anaerobic threshold.",
    duration: "20-60 minutes",
    benefits: [
      {
        name: "Improved Anaerobic Threshold",
        description: "Tempo runs increase your anaerobic threshold, allowing you to sustain a faster pace for longer durations."
      },
      {
        name: "Increased Lactate Processing",
        description: "Tempo runs train your body to process lactate - a byproduct of hard exercise - more effectively, delaying fatigue."
      }
    ]
  },
  {
    name: "Fartlek Run",
    description: "Fartlek is a Swedish term for 'Speed Play.' These workouts involve varying your pace throughout your run, alternating between fast segments and slow jogs.",
    duration: "40-60 minutes",
    benefits: [
      {
        name: "Improved Speed and Endurance",
        description: "The variable intensity of Fartlek runs can improve both speed and endurance."
      },
      {
        name: "Versatility",
        description: "Fartlek runs train your body to handle different speeds and intensities, making it a versatile workout."
      }
    ]
  }
]
// Activity.insertMany(activities);