let db = [
  {id:1, fname: 'John', lname: 'Smith'},
  {id:2, fname: 'Lucy', lname: 'Jark'},
  {id:3, fname: 'Edward', lname: 'Capton'}
];

class Student {
  constructor(id, firstname, lastname){
      this.id = id;
      this.fname = firstname;
      this.lname = lastname;
  }

  save(){
    db.push(this);
  }

  edit(){
    db.forEach((student, index) => {
      if(student.id === this.id){
        db[index] = this;
      }
    });
  }

  static getById(id){
    return db.find(student => student.id === id);
  }

  static getAll(){
    return db;
  }

  static deleteById(id){
    db = db.filter(student => student.id !== id);
  }
}

console.log("Save: 4, 'Tina', 'Xing'")
new Student(4, 'Tina', 'Xing').save(); //save to db
console.log(Student.getAll());
console.log("-----------------------------------");
console.log("Edit to: 4, 'Miss', 'Xing'")
new Student(4, 'Miss', 'Xing').edit() //edit studentId with id=4
console.log(Student.getAll());
console.log("-----------------------------------");
console.log("Delete: 4, 'Miss', 'Xing'")
Student.deleteById(4); //remove studentId=4 from db
console.log(Student.getAll()); //return db;
console.log("-----------------------------------");
console.log("Get By ID: 1, 'Miss', 'Xing'")
console.log(Student.getById(1)); //return {id:1, fname: 'John', lname: 'Smith'}