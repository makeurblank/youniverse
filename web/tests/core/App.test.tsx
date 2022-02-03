import { render } from "@testing-library/react";

import App from "../../src/App";
import sampleImage from "../../assets/images/sample.png";


describe('App', () => {
    it('renders main service introduce', () => {
        const { container } = render(<App />);

        expect(container).toHaveTextContent('마음속 우주를 설계하고, 에너지 레벨을 측정하는');
    });
});

describe('App', () => {
    it('renders google login button', () => {
        const { container_item } = render(<App />);
        
        expect(container_item.find("img").prop("src")).toEqual(sampleImage);
    });
});

describe('App', () => {
    it('simulates button click events', () => {
        const { container_item } = render(<App />);

    })
})


