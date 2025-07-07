import React, { useState } from "react";

const Register = () => {
    const [formData, setFormData] = useState({
        firstname: "",
        lastname: "",
        email: "",
        password: "",
        confirmpassword: ""
    });

    const [formErrors, setFormErrors] = useState({});
    const [touchedFields, setTouchedFields] = useState({});
    const [hasBeenSubmit, setHasBeenSubmit] = useState(false);
    const [users, setUsers] = useState([]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
        validateField(name, value);
    };

    const handleBlur = (e) => {
        const { name } = e.target;
        setTouchedFields({ ...touchedFields, [name]: true });
    };

    const validateField = (name, value) => {
        let errors = { ...formErrors };

        switch (name) {
            case "firstname":
                errors.firstname =
                    value.length < 2 ? "First name must be at least 2 characters." : "";
                break;
            case "lastname":
                errors.lastname =
                    value.length < 2 ? "Last name must be at least 2 characters." : "";
                break;
            case "email":
                errors.email =
                    value.length < 5 || !value.includes("@")
                        ? "Email must be valid and at least 5 characters."
                        : "";
                break;
            case "password":
                errors.password =
                    value.length < 8 ? "Password must be at least 8 characters." : "";
                break;
            case "confirmpassword":
                errors.confirmpassword =
                    value !== formData.password ? "Passwords do not match." : "";
                break;
            default:
                break;
        }

        setFormErrors(errors);
    };

    const validateForm = () => {
        for (let key in formErrors) {
            if (formErrors[key]) return false;
        }
        for (let key in formData) {
            if (formData[key] === "") return false;
        }
        return true;
    };

    const createUser = (e) => {
        e.preventDefault();
        setHasBeenSubmit(true);

        const allTouched = {};
        for (let key in formData) {
            allTouched[key] = true;
        }
        setTouchedFields(allTouched);

        if (validateForm()) {
            setUsers([...users, formData]);
            alert("User created successfully!");
            setFormData({
                firstname: "",
                lastname: "",
                email: "",
                password: "",
                confirmpassword: ""
            });
            setFormErrors({});
            setTouchedFields({});
            setHasBeenSubmit(false);
        } else {
            alert("Please fix the errors before submitting.");
        }
    };

    return (
        <div>
            <form onSubmit={createUser}>
                <div>
                    <label>First Name:</label>
                    <input
                        name="firstname"
                        value={formData.firstname}
                        onChange={handleChange}
                        onBlur={handleBlur}
                    />
                    {touchedFields.firstname && formErrors.firstname && (
                        <p>{formErrors.firstname}</p>
                    )}
                </div>

                <div>
                    <label>Last Name:</label>
                    <input
                        name="lastname"
                        value={formData.lastname}
                        onChange={handleChange}
                        onBlur={handleBlur}
                    />
                    {touchedFields.lastname && formErrors.lastname && (
                        <p>{formErrors.lastname}</p>
                    )}
                </div>

                <div>
                    <label>Email:</label>
                    <input
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        onBlur={handleBlur}
                    />
                    {touchedFields.email && formErrors.email && (
                        <p>{formErrors.email}</p>
                    )}
                </div>

                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        onBlur={handleBlur}
                    />
                    {touchedFields.password && formErrors.password && (
                        <p>{formErrors.password}</p>
                    )}
                </div>

                <div>
                    <label>Confirm Password:</label>
                    <input
                        type="password"
                        name="confirmpassword"
                        value={formData.confirmpassword}
                        onChange={handleChange}
                        onBlur={handleBlur}
                    />
                    {touchedFields.confirmpassword && formErrors.confirmpassword && (
                        <p>{formErrors.confirmpassword}</p>
                    )}
                </div>

                <button type="submit">Register</button>
            </form>

            <div>
                <h2>All Users:</h2>
                <ul>
                    {users.map((user, index) => (
                        <li key={index}>
                            <strong>User {index + 1}</strong>
                            <ul>
                                <li>First Name: {user.firstname}</li>
                                <li>Last Name: {user.lastname}</li>
                                <li>Email: {user.email}</li>
                                <li>Password: {user.password}</li>
                                <li>Confirm Password: {user.confirmpassword}</li>
                            </ul>
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default Register;
