"use strict";
// Validation Functions
const nameOk = (n) => {
    return /^[A-Za-z ]{2,}$/.test(n);
};
const emlCheck = (e) => {
    return /^[^@]+@[^.]+\..+$/.test(e);
};
const howGoodPass = (p) => {
    const up = /[A-Z]/.test(p), low = /[a-z]/.test(p), num = /[0-9]/.test(p), spl = /[^A-Za-z0-9]/.test(p), len = p.length >= 8;
    return up && low && num && spl && len ? "strong" : up && low && num && len ? "normal" : "weak";
};
const numOkay = (n) => {
    return /^\d{9,}$/.test(n);
};
// Employee Class
class Employee {
    constructor(name, email, password, phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.empID = Math.floor(Math.random() * 1000);
    }
    getDetails() {
        return { name: this.name, email: this.email, empID: this.empID };
    }
}
// Vehicle Class
class Vehicle {
    constructor(vName, vType, plateNumber, owner) {
        this.vName = vName;
        this.vType = vType;
        this.plateNumber = plateNumber;
        this.owner = owner;
    }
    getVehicleDetails() {
        return { name: this.vName, type: this.vType, plate: this.plateNumber, owner: this.owner.getDetails() };
    }
}
// Pass Class
class Pass {
    constructor(validityDays, vehicle) {
        this.validUntil = new Date();
        this.validUntil.setDate(this.validUntil.getDate() + validityDays);
        const cost = { "Cycle": 5, "MotorCycle": 10, "Four Wheeler": 20 };
        this.price = validityDays;
        this.vehicle = vehicle;
    }
    getPassDetails() {
        return { validUntil: this.validUntil, price: this.price, vehicle: this.vehicle.getVehicleDetails() };
    }
}
// Employee Form Handler
const empFormStart = () => {
    const frm = document.querySelector("#addEmployee form");
    frm.innerHTML = "";
    let gotName = "";
    const steps = [
        { label: "What is your name?", name: "name", type: "text", validate: nameOk },
        { label: `Hi ${gotName}! What's your gender?`, name: "gender", type: "radio", options: ["Male", "Female", "Other"] },
        { label: "Email please", name: "email", type: "email", validate: emlCheck },
        { label: "Make a password", name: "password", type: "password" },
        { label: "Retype password", name: "confirmPassword", type: "password" },
        { label: "Phone number?", name: "number", type: "number", validate: numOkay }
    ];
    let current = 0;
    const collected = {};
    const nxt = () => {
        const f = steps[current];
        frm.innerHTML = "";
        const lbl = document.createElement("label");
        lbl.innerText = f.label;
        frm.appendChild(lbl);
        let inp;
        // if the input form is radio and it also has option add it in the layer
        if (f.type === "radio" && f.options) {
            f.options.forEach(g => {
                const r = document.createElement("input");
                r.type = "radio";
                r.name = f.name;
                r.value = g;
                const t = document.createElement("span");
                t.innerText = " " + g;
                frm.appendChild(r);
                frm.appendChild(t);
            });
            // else add layer for the input if the type is text or password
        }
        else {
            inp = document.createElement("input");
            inp.type = f.type;
            inp.name = f.name;
            frm.appendChild(inp);
            if (f.name === "password") {
                inp.addEventListener("input", () => {
                    const str = howGoodPass(inp.value);
                    inp.style.border = str === "strong" ? "4px solid green" : str === "normal" ? "4px solid orange" : "4px solid red";
                });
            }
        }
        // to go to the next form input the submit button funcionality
        frm.addEventListener("submit", (e) => {
            e.preventDefault();
            let val;
            // if the type is radio
            if (f.type === "radio") {
                const ch = frm.querySelector(`input[name="${f.name}"]:checked`);
                val = ch ? ch.value : "";
                if (!val)
                    return;
            }
            else {
                // if the type is password
                const inputElement = frm.querySelector(`input[name="${f.name}"]`);
                val = inputElement.value;
                // password and confirm password is same or not
                if (f.name === "confirmPassword" && val !== collected.password) {
                    alert("Passwords do not match!");
                    return;
                }
                // if type is validate
                if (f.validate && !f.validate(val)) {
                    alert("Invalid input, try again.");
                    return;
                }
            }
            collected[f.name] = val;
            current++;
            current < steps.length ? nxt() : console.log("Employee ID:", Math.floor(Math.random() * 1000));
            carForm(new Employee("hsd", "dhd@gmail.com", "123", "12345678"));
        });
        // creating a buttn for submit the form
        const b = document.createElement("button");
        b.type = "submit";
        b.innerText = "Next";
        b.className = "btnNext";
        frm.appendChild(b);
    };
    nxt();
};
// Pricing function
const showPriceList = (vType) => {
    const cost = { "Cycle": [5, 100, 500], "MotorCycle": [10, 200, 1000], "Four Wheeler": [20, 500, 3500] };
    // document pricing element 
    const box = document.getElementById("pricing");
    box.innerHTML = "<h3>Pick price:</h3>";
    const selPlan = document.createElement("select");
    selPlan.className = "Currency";
    // setting the data for monthly daily or yearly
    ["Daily", "Monthly", "Yearly"].forEach((p, i) => {
        const opt = document.createElement("option");
        opt.value = String(i);
        opt.innerText = `${p} - ₹${cost[vType][i]}`;
        selPlan.appendChild(opt);
    });
    // setting the pricing function
    const selCurr = document.createElement("select");
    selCurr.className = "Currency";
    ["INR", "USD", "YEN"].forEach(curr => {
        const o = document.createElement("option");
        o.value = curr;
        o.innerText = curr;
        selCurr.appendChild(o);
    });
    // button 
    const btn = document.createElement("button");
    btn.innerText = "Get Pass";
    btn.className = "btnNext";
    const res = document.createElement("div");
    // onclick function for button
    btn.onclick = () => {
        const idx = parseInt(selPlan.value);
        let price = cost[vType][idx];
        const currency = selCurr.value;
        let out = price;
        if (currency === "USD")
            out = parseFloat((price / 83).toFixed(2));
        else if (currency === "YEN")
            out = parseFloat((price * 1.57).toFixed(2));
        res.innerText = `You selected ${currency} ${out}. Price in USD: $${(price / 83).toFixed(2)}`;
    };
    // appending the elements in the dom
    box.appendChild(selPlan);
    box.appendChild(selCurr);
    box.appendChild(btn);
    box.appendChild(res);
};
// Vehicle Registration Form Function
const carForm = (emp) => {
    const frm = document.querySelector("#addVehicle form");
    frm.innerHTML = "";
    const steps = [
        { label: "Vehicle name?", name: "vname", type: "text" },
        { label: "Type of vehicle?", name: "vtype", type: "select", options: ["Cycle", "MotorCycle", "Four Wheeler"] },
        { label: "Plate number?", name: "vnum", type: "text" }
    ];
    let current = 0;
    const collected = {};
    const nextStep = () => {
        const f = steps[current];
        frm.innerHTML = "";
        const lbl = document.createElement("label");
        lbl.innerText = f.label;
        frm.appendChild(lbl);
        let inp;
        if (f.type === "select" && f.options) {
            inp = document.createElement("select");
            f.options.forEach(option => {
                const opt = document.createElement("option");
                opt.value = option;
                opt.innerText = option;
                inp.appendChild(opt);
            });
        }
        else {
            inp = document.createElement("input");
            inp.type = f.type;
        }
        inp.name = f.name;
        frm.appendChild(inp);
        frm.addEventListener("submit", (e) => {
            e.preventDefault();
            const inputElement = frm.querySelector(`[name="${f.name}"]`);
            const v = inputElement.value;
            if (!v) {
                alert("Don't leave it blank");
                return;
            }
            collected[f.name] = v;
            current++;
            if (current < steps.length) {
                nextStep();
            }
            else {
                const newVehicle = new Vehicle(collected.vname, collected.vtype, collected.vnum, emp);
                console.log(newVehicle.getVehicleDetails());
            }
        });
        const btn = document.createElement("button");
        btn.type = "submit";
        btn.innerText = "Next";
        btn.className = "btnNext";
        frm.appendChild(btn);
    };
    nextStep();
};
// Call the functions
empFormStart();
showPriceList("Cycle");
