// correct name ornot
function isValidName(name) {
    return /^[A-Za-z ]{2,}$/.test(name);
}

// validating emails
function isValidEmail(email) {
    return /^[^@]+@[^.]+\..+$/.test(email);
}

// strength
function checkPasswordStrength(password) {
    const hasUpper = /[A-Z]/.test(password);
    const hasLower = /[a-z]/.test(password);
    const hasNumber = /[0-9]/.test(password);
    const hasSpecial = /[^A-Za-z0-9]/.test(password);
    const isLong = password.length >= 8;

    if (hasUpper && hasLower && hasNumber && hasSpecial && isLong) {
        return "strong";
    } else if (hasUpper && hasLower && hasNumber && isLong) {
        return "normal";
    } else {
        return "weak";
    }
}

// number 
function isValidNumber(num) {
    return /^\d{9,}$/.test(num);
}

// ------------ EMPLOYEE FORM LOGIC -------------//
function startEmployeeForm() {
    const form = document.querySelector("#addEmployee form");
    form.innerHTML = ""; // Clear existing form
    let name ="";
    const fields = [
        {
            label: "Enter your full name",
            name: "name", type: "text",
            validate: isValidName
        },
        {
            label: `Hi ${name}! Can I know your gender?`,
            name: "gender", type: "radio",
            options: ["Male", "Female", "Other"]
        },
        {
            label: "Enter your email",
            name: "email", type: "email",
            validate: isValidEmail
        },
        {
            label: "Create a password",
            name: "password", type: "password",
            validate: checkPasswordStrength
        },
        {
            label: "Confirm your password",
            name: "confirmPassword", type: "password"
        },
        {
            label: "Enter your contact number",
            name: "number", type: "number", validate: isValidNumber
        }
    ];

    let step = 0;
    const data = {};

    showNextField();

    function showNextField() {
        const field = fields[step];
        form.innerHTML = "";

        const label = document.createElement("label");
        name = data.name;
        label.innerText = field.label;
        form.appendChild(label);
        let input;
        if (field.type === "radio") {
            field.options.forEach(opt => {
                const radio = document.createElement("input");
                radio.type = "radio";
                radio.style.display = 'inline-flex';
                radio.name = field.name;
                radio.value = opt;

                const span = document.createElement("span");
                span.innerText = " " + opt;

                form.appendChild(radio);
                form.appendChild(span);

            });

        } else {
            input = document.createElement("input");
            input.type = field.type;
            input.name = field.name;
            form.appendChild(input);

            if (field.name === "password") {
                input.addEventListener("input", function () {
                    const strength = checkPasswordStrength(input.value);
                   if (strength === "strong") {
                        input.style.border = "4px solid green";
                    } else if (strength === "normal") {
                        input.style.border = "4px solid orange";
                    } else {
                        input.style.border = "4px solid red";
                    }
                    
                    
        
                });
            }
        }


        // Listen for Enter or selection
        form.addEventListener("submit", function (e) {
            e.preventDefault();

            let value;

            if (field.type === "radio") {
                const selected = form.querySelector(`input[name="${field.name}"]:checked`);
                value = selected ? selected.value : null;
                if (!value) {
                    return;
                }
            } else {
                value = form.querySelector(`input[name="${field.name}"]`).value;
                if (field.name === "confirmPassword" && value !== data.password) {
                    alert("Passwords do not match!");
                    return;
                }
                if (field.validate && !field.validate(value)) {
                    alert("Please enter valid input.");
                    return;
                }
            }

            data[field.name] = value;
            step++;

            if (step < fields.length) {
                showNextField();
            } else {
                console.log("Id " + Math.floor(Math.random() * 1000));
                document.querySelector("#addEmployee").style.display = "none";
                startVehicleForm(data);
            }
        });

        // Add submit button
        const btn = document.createElement("button");
        btn.type = "submit";
        btn.innerText = "Next";
        btn.className = "btnNext";
        form.appendChild(btn);
    }
}



// <<---------------------------- VEHICLE FORM LOGIC------------------------->>
function startVehicleForm(employeeData) {
    const form = document.querySelector("#addVehicle form");
    form.innerHTML = "";

    const fields = [
        {
            label: "Enter your vehicle name",
            name: "vname", type: "text"
        },
        {
            label: "Which type of vehicle?",
            name: "vtype", type: "select",
            options: ["Cycle", "MotorCycle", "Four Wheeler"]
        },
        {
            label: "Enter vehicle number",
            name: "vnum", type: "text"
        },
        {
            label: "Enter employee ID",
            name: "empid", type: "number"
        },
        {
            label: "Vehicle identification",
            name: "ident", type: "textarea"
        }
    ];

    let step = 0;
    const data = {};

    showNextField();

// <---------------------next field in it ------------------------>
    function showNextField() {
        const field = fields[step];
        form.innerHTML = "";

        const label = document.createElement("label");
        label.innerText = field.label;
        form.appendChild(label);

        let input;
        if (field.type === "select") {
            input = document.createElement("select");
            field.options.forEach(opt => {
                const optEl = document.createElement("option");
                optEl.value = opt;
                optEl.innerText = opt;
                input.appendChild(optEl);
            });
        } else if (field.type === "textarea") {
            input = document.createElement("textarea");
        } else {
            input = document.createElement("input");
            input.type = field.type;
        }

        input.name = field.name;
        form.appendChild(input);

        form.addEventListener("submit", function (e) {
            e.preventDefault();
            const value = form.querySelector(`[name="${field.name}"]`).value;
            if (!value) {
                alert("This field is required.");
                return;
            }
            data[field.name] = value;
            step++;
            if (step < fields.length) {
                showNextField();
            } else {
                document.querySelector("#addVehicle").style.display = "none";
                showPricing(data.vtype);
            }
        });

        const btn = document.createElement("button");
        btn.type = "submit";
        btn.innerText = "Next";
        btn.className = "btnNext";
        form.appendChild(btn);
    }
}

// <<----------------------SHOW PRICING---------------------->>
function showPricing(vehicleType) {
    const prices = {
        "Cycle": [5, 100, 500],
        "MotorCycle": [10, 200, 1000],
        "Four Wheeler": [20, 500, 3500]
    };

    const priceBox = document.getElementById("pricing");
    priceBox.innerHTML = "<h3>Select your pricing plan:</h3>";

    const planSelect = document.createElement("select");
    const plans = ["Daily", "Monthly", "Yearly"];
    plans.forEach((p, i) => {
        const opt = document.createElement("option");
        opt.value = i;
        opt.innerText = `${p} - ₹${prices[vehicleType][i]}`;
        planSelect.appendChild(opt);
    });

    const currencySelect = document.createElement("select");
    ["INR", "USD", "YEN"].forEach(curr => {
        const opt = document.createElement("option");
        opt.value = curr;
        opt.innerText = curr;
        currencySelect.appendChild(opt);
    });

    const btn = document.createElement("button");
    btn.innerText = "Get Pass";
    btn.className = "btnNext";

    const result = document.createElement("div");

    btn.onclick = function () {
        const index = planSelect.value;
        const inr = prices[vehicleType][index];
        const currency = currencySelect.value;

        let converted = inr;
        if (currency === "USD") converted = (inr / 83).toFixed(2);
        if (currency === "YEN") converted = (inr * 1.57).toFixed(2);

        const usdValue = (inr / 83).toFixed(2);

        result.innerText = `You selected ${currency} ${converted}. Price $${usdValue}.`;
    };

    priceBox.appendChild(planSelect);
    priceBox.appendChild(currencySelect);
    
    priceBox.appendChild(btn);
    priceBox.appendChild(result);
}

// <-------------------START EVERYTHING ON PAGE LOAD-------------------------->
startEmployeeForm();
showPricing('Cycle');