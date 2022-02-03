import React from "react";
import { render } from "@testing-library/react";
import App from "../../src/App";
import 

describe('App', () => {
    it('simulate login button click', () => {
        const { container_google_login } = render(<App/ >);

        expect(container_google_login).toEqual("")
    })
})