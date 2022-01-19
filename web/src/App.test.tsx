import { render } from "@testing-library/react";

import App from "./App";

describe('App', () => {
    it('renders main service introduce', () => {
        const { container } = render(<App />);

        expect(container).toHaveTextContent('마음속 우주를 설계하고, 에너지 레벨을 측정하는');
    });
});