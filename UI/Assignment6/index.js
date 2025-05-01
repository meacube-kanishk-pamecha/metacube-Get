// name check
function nameOk(n) {
    return /^[A-Za-z ]{2,}$/.test(n);
}


// email check
function emlCheck(e) {
    return /^[^@]+@[^.]+\..+$/.test(e);
}


// pass strong?
function howGoodPass(p) {
    let up = /[A-Z]/.test(p);
    let low = /[a-z]/.test(p);
    let num = /[0-9]/.test(p);
    let spl = /[^A-Za-z0-9]/.test(p);
    let len = p.length >= 8;


    if (up && low && num && spl && len) {
        return "strong";
    } else if (up && low && num && len) {
        return "normal";
    } else {
        return "weak";
    }
}


// num valid
function numOkay(n) {
    return /^\d{9,}$/.test(n);
}




// ========== emp form ============
function empFormStart() {
    let frm = document.querySelector("#addEmployee form");
    frm.innerHTML = "";


    let gotName = "";
    let steps = [
        {
            label: "What is your name?",
            name: "name", type: "text",
            validate: nameOk
        },
        {
            label: `Hi ${gotName}! What's ur gender?`,
            name: "gender", type: "radio",
            options: ["Male", "Female", "Other"]
        },
        {
            label: "Email pls",
            name: "email", type: "email",
            validate: emlCheck
        },
        {
            label: "Make a password",
            name: "password", type: "password",
            validate: howGoodPass
        },
        {
            label: "Retype password",
            name: "confirmPassword", type: "password"
        },
        {
            label: "Phone number?",
            name: "number", type: "number", validate: numOkay
        }
    ];


    let current = 0;
    let collected = {};


    nxt();


    function nxt() {
        let f = steps[current];
        frm.innerHTML = "";


        let lbl = document.createElement("label");
        gotName = collected.name;
        lbl.innerText = f.label;
        frm.appendChild(lbl);


        let inp;


        if (f.type === "radio") {
            f.options.forEach(g => {
                let r = document.createElement("input");
                r.type = "radio";
                r.name = f.name;
                r.value = g;


                let t = document.createElement("span");
                t.innerText = " " + g;


                frm.appendChild(r);
                frm.appendChild(t);
            });


        } else {
            inp = document.createElement("input");
            inp.type = f.type;
            inp.name = f.name;
            frm.appendChild(inp);


            if (f.name === "password") {
                inp.addEventListener("input", function () {
                    let str = howGoodPass(inp.value);
                    if (str === "strong") inp.style.border = "4px solid green";
                    else if (str === "normal") inp.style.border = "4px solid orange";
                    else inp.style.border = "4px solid red";
                });
            }
        }


        frm.addEventListener("submit", function (e) {


            let val;


            if (f.type === "radio") {
                let ch = frm.querySelector(`input[name="${f.name}"]:checked`);
                val = ch ? ch.value : null;
                if (!val) return;
            } else {
                val = frm.querySelector(`input[name="${f.name}"]`).value;
                if (f.name === "confirmPassword" && val !== collected.password) {
                    alert("No match password!");
                    return;
                }
                if (f.validate && !f.validate(val)) {
                    alert("Invalid input, try again.");
                    return;
                }
            }


            collected[f.name] = val;
            current++;


            if (current < steps.length) {
                nxt();
            } else {
                console.log("Id is " + Math.floor(Math.random() * 1000));
                document.querySelector("#addEmployee").style.display = "none";
                carFormNow(collected);
            }
        });


        let b = document.createElement("button");
        b.type = "submit";
        b.innerText = "Next";
        b.className = "btnNext";
        frm.appendChild(b);
    }
}




// <------------ car Parking ---------->
function carFormNow(empD) {
    let frm = document.querySelector("#addVehicle form");
    frm.innerHTML = "";


    let stepz = [
        { label: "Vehicle name?", name: "vname", type: "text" },
        { label: "Type of vehicle?", name: "vtype", type: "select", options: ["Cycle", "MotorCycle", "Four Wheeler"] },
        { label: "Plate number?", name: "vnum", type: "text" },
        { label: "Emp ID?", name: "empid", type: "number" },
        { label: "Some ID of vehicle?", name: "ident", type: "textarea" }
    ];


    let s = 0;
    let dataz = {};


    nextField();


    function nextField() {
        let f = stepz[s];
        frm.innerHTML = "";


        let l = document.createElement("label");
        l.innerText = f.label;
        frm.appendChild(l);


        let i;
        if (f.type === "select") {
            i = document.createElement("select");
            f.options.forEach(x => {
                let o = document.createElement("option");
                o.value = x;
                o.innerText = x;
                i.appendChild(o);
            });
        } else if (f.type === "textarea") {
            i = document.createElement("textarea");
        } else {
            i = document.createElement("input");
            i.type = f.type;
        }


        i.name = f.name;
        frm.appendChild(i);


        frm.addEventListener("submit", function (e) {
            let v = frm.querySelector(`[name="${f.name}"]`).value;
            if (!v) {
                alert("Don't leave it blank");
                return;
            }
            dataz[f.name] = v;
            s++;
            if (s < stepz.length) {
                nextField();
            } else {
                document.querySelector("#addVehicle").style.display = "none";
                showPriceList(dataz.vtype);
            }
        });


        let b = document.createElement("button");
        b.type = "submit";
        b.innerText = "Next";
        b.className = "btnNext";
        frm.appendChild(b);
    }
}




// <<---------------------------Pricing--------------------------->>
function showPriceList(vType) {
    let cost = {
        "Cycle": [5, 100, 500],
        "MotorCycle": [10, 200, 1000],
        "Four Wheeler": [20, 500, 3500]
    };


    let box = document.getElementById("pricing");
    box.innerHTML = "<h3>Pick price:</h3>";


    let selPlan = document.createElement("select");
    selPlan.className="Currency"
    let allPlans = ["Daily", "Monthly", "Yearly"];


    allPlans.forEach((p, i) => {
        let opt = document.createElement("option");
        opt.value = i;
        opt.innerText = p + " - ₹" + cost[vType][i];
        selPlan.appendChild(opt);
    });


    let selCurr = document.createElement("select");
    selCurr.className="Currency";
    ["INR", "USD", "YEN"].forEach(curr => {
        let o = document.createElement("option");
        o.value = curr;
        o.innerText = curr;
        
        selCurr.appendChild(o);
    });


    let btn = document.createElement("button");
    btn.innerText = "Get Pass";
    btn.className = "btnNext";


    let res = document.createElement("div");


    btn.onclick = function () {
        let idx = selPlan.value;
        let price = cost[vType][idx];
        let c = selCurr.value;


        let out = price;
        if (c === "USD") out = (price / 83).toFixed(2);
        else if (c === "YEN") out = (price * 1.57).toFixed(2);


        let usd = (price / 83).toFixed(2);


        res.innerText = "You selected " + c + " " + out + ". Price $" + usd;
    };


    box.appendChild(selPlan);
    box.appendChild(selCurr);
    box.appendChild(btn);
    box.appendChild(res);
}




empFormStart();
showPriceList('Cycle');
 
