import { render } from "@testing-library/react";

import { Youniverse }  from "../../src/Youniverse";

describe('Youniverse', () => {
    it('renders item', () => {
        const { container_youniverse } = render(<Youniverse/ >);

        expect(container_youniverse).toBe('test.png');
    });
});